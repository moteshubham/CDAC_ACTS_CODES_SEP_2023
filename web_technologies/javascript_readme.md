## Synchronous wait (only for testing!):

```javascript
const syncWait = (ms) => {
  const end = Date.now() + ms;
  while (Date.now() < end) continue;
};
```

Usage:

```javascript
console.log("one");
syncWait(5000);
console.log("two");
```

## Asynchronous wait:

```javascript
const asyncWait = (ms) => new Promise((resolve) => setTimeout(resolve, ms));
```

Usage:

```javascript
(async () => {
  console.log("one");
  await asyncWait(5000);
  console.log("two");
})();
```

## JavaScript: Event Loop & Callback Queue Explained

When JavaScript is run on a browser, the following components come into play:

#### The JavaScript Engine with its Call stack and its Memory heap

1. The Event Loop
2. The Callback Queue
3. The Web API

### Event Loop

Remember that:

#### def1,

JavaScript has a runtime model based on an event loop, which is responsible for executing the code, collecting and processing events, and executing queued sub-tasks. This model is quite different from models in other languages like C and Java.

#### def2,

The event loop is what allows Node.js to perform non-blocking I/O operations — despite the fact that JavaScript is single-threaded — by offloading operations to the system kernel whenever possible.

Since most modern kernels are multi-threaded, they can handle multiple operations executing in the background. When one of these operations completes, the kernel tells Node.js so that the appropriate callback may be added to the poll queue to eventually be executed. We'll explain this in further detail later in this topic.

#### def3,

JavaScript is a single-threaded language.

The Event-loop is the secret sauce that helps give JavaScript its multi-tasking abilities (almost!).

This loop constantly checks whether the call stack is empty or not and if it is, the functions waiting to be executed in the callback queue get pushed to the call stack.

Finding it tough to understand? Don’t worry! It will be much easier to understand with the example below.

Let’s move on to the next component before that.

Photo by Jexo on Unsplash

### Callback Queue

The Callback queue is a data structure that operates on the FIFO (first-in-first-out) principle.

Callback functions that need to be asynchronously executed, are pushed onto the callback queue.

These are later pushed to the Call stack to be executed (when the event loop finds an empty call stack).

### Web API

These are different APIs provided by the web browser that helps you build web applications.

A few that you might be familiar with are:

setTimeout()
setInterval()
clearTimeout()
clearInterval()
fetch()
Remember that these are not in-built into the JavaScript engine.

Read more about Web APIs here:
https://developer.mozilla.org/en-US/docs/Web/API


Javascript can be added to our HTML code in mostly 2 ways:
  1. Internal Javascript: 
  2. External Javascript: 


## explain hoisting in js


Note - Variable initializations are not hoisted, only variable declarations are hoisted:

To avoid hoisting, you can run javascript in strict mode by using “use strict” on top of the code:

In ECMAScript 2015, let and const are hoisted but not initialized. Referencing the variable in the block before the variable declaration results in a ReferenceError because the variable is in a "temporal dead zone" from the start of the block until the declaration is processed.

