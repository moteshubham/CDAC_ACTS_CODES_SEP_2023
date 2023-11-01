
import axios from 'axios'

const axios = require('axios');
axios
.get('https://www.boredapi.com/api/activity')
.then(response =>{
  console.log(`here : ${response.data.activity}`)
})

console.log("done");
