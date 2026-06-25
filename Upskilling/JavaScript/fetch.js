fetch("https://jsonplaceholder.typicode.com/posts",{

method:"POST",

body:JSON.stringify({
name:"Ram"
}),

headers:{
"Content-Type":"application/json"
}

})

.then(response=>response.json())
.then(data=>console.log(data));