function f1() {
  console.log("in f1");
}

function f2() {
  console.log("in f2");
}

async function f3() {
  setTimeout(() => {
    //here setTimeout goes async
    console.log("in f3");
  }, 3000);
  for (let i = 0; i < 7e9; i++) {
    // Do nothing, just waste time
  }
  console.log("in f3 before setime");
  //but as f3 is still async, this line will be printed on priority,
  // blocking the main thread and then proram will continue
}
function f4() {
  console.log("in f4");
}

console.log("before");
f3();
setTimeout(f2, 2000);
setTimeout(f1, 1);

const syncWait = (ms) => {
  const end = Date.now() + ms;
  while (Date.now() < end) continue;
};

//syncWait(10000);
//f4();

console.log("after");
