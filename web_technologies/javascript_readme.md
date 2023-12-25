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
