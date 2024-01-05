const http = require("http");
const server = http.createServer((req, res) => {
  //console.log("request URL: " + req.url + " Method: " + req.method);
  // console.log("-----------------------------");
  // console.log("request object: ", req);
  //console.log("response object: ", res);
  res.writeHead(200, { "content-type": "text/html" });
  res.write("<h1>Hello, this is written by server</h1>");
  res.end(); //here the data is flushed
});

server.listen(9090, () => {
  console.log("server started at 9090 port no");
});
