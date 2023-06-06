import User,{printAge} from './user.js'

const user = new User('Samay',20)
console.log(user)
user.printName();
printAge(user);

//Use bable for modules since older browsers don't support modules.