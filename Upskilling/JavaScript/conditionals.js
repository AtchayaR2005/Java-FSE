let seats=10;

if(seats>0){
console.log("Registration Open");
}
else{
console.log("Event Full");
}

let events=["Music","Sports"];

events.forEach(function(event){
console.log(event);
});

try{
let user="John";
console.log(user);
}
catch(error){
console.log(error);
}