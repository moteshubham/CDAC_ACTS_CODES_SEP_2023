function addTodo() {
  console.log("addTodo called")
  let todo_item = document.getElementById("todo-item").value
  if (todo_item.length > 0) {
    localStorage.setItem(`item${localStorage.length + 1}`, todo_item)
    window.location.reload()
  } else {
    document.getElementById("todo-item").value = "kahitri lihi bho"
  }
  return false
}

function showTodo() {
  console.log("showTodo called")
  if (localStorage.length === 0) {
    console.log("inside IF showTodo called")
    document.getElementById("empty").innerHTML = "List is Empty"
    return
  }

  var todo_item = localStorage.getItem("item")
  var ele = " <div class='todo-list' >"
  for (let i = 0; i < localStorage.length; i++) {
    console.log("inside for loop showtodo")
    const key = localStorage.key(`item${i + 1}`)
    const value = localStorage.getItem(key)
console.log(value);
    ele += " <div class='todo-field'> "
    ele += `<input type="text" value="${value}" id="render-todo${i + 1}"  />`
    ele += "<button>Edit</button><button>Delete</button></div>"
  }
  ele += "</div>"
  document.getElementById("print").innerHTML = ele
}
