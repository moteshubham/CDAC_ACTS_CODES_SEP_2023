

function print(value) {
  console.log(value);
}

function useCallback(callback) {
  callback("Hello")
}

useCallback(print)


console.log("done");
