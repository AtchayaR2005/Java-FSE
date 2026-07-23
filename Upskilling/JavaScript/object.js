class Event{

constructor(name,seats){
this.name=name;
this.seats=seats;
}

checkAvailability(){
return this.seats>0;
}

}

let event1=new Event("Music",20);

console.log(event1.checkAvailability());

console.log(Object.entries(event1));