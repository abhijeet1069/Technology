export default class User{ //by default export User class in user.js 
    constructor(name,age){
        this.name = name;
        this.age = age;
    }

    printName(){
        console.log(`User's name is ${this.name}`);
    }
}

export function printAge(user){
    console.log(`User is ${user.age} years old`);
}