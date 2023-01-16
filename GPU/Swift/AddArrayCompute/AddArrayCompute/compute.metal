#include <metal_stdlib>

using namespace metal;


/*kernel function to run in GPU
 CPU and GPU are not connected directly but via shared memory buffer.
 
 
 index represents location thread
    uint - 1-d array
    unit2 - 2-d array
 */
kernel void addition_compute_function(constant int *arr1[[buffer(0)]],
                                      constant int *arr2[[buffer(1)]],
                                      device int *resultArray[[buffer(2)]],
                                      uint index[[thread_position_in_grid]]){
    
    resultArray[index] = arr1[index] + arr2[index];
}


