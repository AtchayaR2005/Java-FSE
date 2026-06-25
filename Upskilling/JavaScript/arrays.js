let events=["Music","Sports"];

events.push("Workshop");

console.log(events);

let music=
events.filter(event=>event=="Music");

console.log(music);

let display=
events.map(event=>"Event: "+event);

console.log(display);