console.log("first")

function addTodo() {
  let todo_item = document.getElementById("todo-item").value

  localStorage.setItem("item", todo_item)
  showTodo()
  return false
}

function showTodo() {
  var todo_item = localStorage.getItem("item")
  document.getElementById("render-todo").value = todo_item
  console.log(todo_item)
}
