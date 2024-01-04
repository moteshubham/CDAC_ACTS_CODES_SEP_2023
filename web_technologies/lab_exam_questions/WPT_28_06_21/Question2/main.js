const fs = require('fs');
var filename = "sample_file.txt"

const numbers=fs.readFileSync(filename, "utf8").split("\n").map(Number)
const squares = numbers.map(x => x*x)
squares.map(n => console.log(n))
let total = squares.reduce((acc,val)=>acc+val)
console.log("Total : ",total)
let sum = numbers.reduce((acc,val)=>acc+val)
let average = sum/numbers.length
console.log("Average : ",average);

