const button = document.querySelector("button");
let colorState = true;

button.addEventListener("click", () => {
  if (colorState === true) {
    document.body.style.backgroundColor = "rgb(0,0,0)";
    document.body.style.color = "rgb(245,245,245)";
    colorState = false;
  } else {
    document.body.style.backgroundColor = "rgb(255,255,255)";
    document.body.style.color = "rgb(0,0,0)";
    colorState = true;
  }
});
