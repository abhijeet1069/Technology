/**
 Synopsis : Using GPU to compute arrays.
 Date Created : 14th January 2023
 
 */
import MetalKit

func getRandomArray(size:Int)->[Int]{
    var intArray = [Int](repeating: 0, count:size)
    for index in 0..<size{
        intArray[index] = Int.random(in: 0...100)
    }
    return intArray;
}

func basicForLoop(arr1:[Int], arr2:[Int]){
    print("Basic For Loop Way")
    let startTime = CFAbsoluteTimeGetCurrent()
    var result = [Int].init(repeating:0, count:arr1.count)
    for i in 0..<result.count{
        result[i] = arr1[i] + arr2[1]
    }
    
    for i in 0..<result.count{
        print("\(arr1[i]) + \(arr2[i]) = \(result[i])")
    }
    
    let timeElapsed = CFAbsoluteTimeGetCurrent()-startTime;
    print("Time elapsed \(String(format: "%0.5f", timeElapsed))")
    print()
}

func computeWay(arr1:[Int], arr2:[Int]){
    // Begin the process
        let startTime = CFAbsoluteTimeGetCurrent()
        let count = arr1.count
        // The GPU we want to use
        let device = MTLCreateSystemDefaultDevice()

        // A fifo queue for sending commands to the gpu
        let commandQueue = device?.makeCommandQueue()

        // A library for getting our metal functions
        let gpuFunctionLibrary = device?.makeDefaultLibrary()

        // Grab our gpu function
        let additionGPUFunction = gpuFunctionLibrary?.makeFunction(name: "addition_compute_function")

        var additionComputePipelineState: MTLComputePipelineState!
        do {
            additionComputePipelineState = try device?.makeComputePipelineState(function: additionGPUFunction!)
        } catch {
          print(error)
        }
        
        print()
        print("GPU Way")

        // Create the buffers to be sent to the gpu from our arrays
        let arr1Buff = device?.makeBuffer(bytes: arr1,
                                          length: MemoryLayout<Float>.size * count,
                                          options: .storageModeShared)

        let arr2Buff = device?.makeBuffer(bytes: arr2,
                                          length: MemoryLayout<Float>.size * count,
                                          options: .storageModeShared)

        let resultBuff = device?.makeBuffer(length: MemoryLayout<Float>.size * count,
                                            options: .storageModeShared)

        // Create a buffer to be sent to the command queue
        let commandBuffer = commandQueue?.makeCommandBuffer()

        // Create an encoder to set vaulues on the compute function
        let commandEncoder = commandBuffer?.makeComputeCommandEncoder()
        commandEncoder?.setComputePipelineState(additionComputePipelineState)

        // Set the parameters of our gpu function
        commandEncoder?.setBuffer(arr1Buff, offset: 0, index: 0)
        commandEncoder?.setBuffer(arr2Buff, offset: 0, index: 1)
        commandEncoder?.setBuffer(resultBuff, offset: 0, index: 2)

        // Figure out how many threads we need to use for our operation
        let threadsPerGrid = MTLSize(width: count, height: 1, depth: 1)
        let maxThreadsPerThreadgroup = additionComputePipelineState.maxTotalThreadsPerThreadgroup // 1024
        let threadsPerThreadgroup = MTLSize(width: maxThreadsPerThreadgroup, height: 1, depth: 1)
        commandEncoder?.dispatchThreads(threadsPerGrid,
                                        threadsPerThreadgroup: threadsPerThreadgroup)

        // Tell the encoder that it is done encoding.  Now we can send this off to the gpu.
        commandEncoder?.endEncoding()

        // Push this command to the command queue for processing
        commandBuffer?.commit()

        // Wait until the gpu function completes before working with any of the data
        commandBuffer?.waitUntilCompleted()

        // Get the pointer to the beginning of our data
        var resultBufferPointer = resultBuff?.contents().bindMemory(to: Float.self,
                                                                    capacity: MemoryLayout<Float>.size * count)

        // Print out all of our new added together array information
        for i in 0..<3 {
            print("\(arr1[i]) + \(arr2[i]) = \(Float(resultBufferPointer!.pointee) as Any)")
            resultBufferPointer = resultBufferPointer?.advanced(by: 1)
        }
        
        // Print out the elapsed time
        let timeElapsed = CFAbsoluteTimeGetCurrent() - startTime
        print("Time elapsed \(String(format: "%.05f", timeElapsed)) seconds")
        print()
}


func main(){
    let count = 10000
    let array1 = getRandomArray(size: count)
    let array2 = getRandomArray(size:count)
    computeWay(arr1:array1, arr2:array2)
}

main()




