const forms = document.querySelector(".forms"),
      pwShowHide = document.querySelectorAll(".eye-icon"),
      links = document.querySelectorAll(".link");
const loginDiv = document.getElementById("login");
const loginContainer = document.querySelector(".container");

const closeBtn = document.querySelectorAll("#close-btn")

closeBtn.forEach(btn =>{
    btn.addEventListener("click",()=>{
        loginContainer.style.display = "none"
    })
});

pwShowHide.forEach(eyeIcon => {
    eyeIcon.addEventListener("click", () => {
        let pwFields = eyeIcon.parentElement.parentElement.querySelectorAll(".password");
        
        pwFields.forEach(password => {
            if(password.type === "password"){
                password.type = "text";
                eyeIcon.classList.replace("bx-hide", "bx-show");
                return;
            }
            password.type = "password";
            eyeIcon.classList.replace("bx-show", "bx-hide");
        })
        
    })
})      

links.forEach(link => {
    link.addEventListener("click", e => {
       e.preventDefault(); //preventing form submit
       forms.classList.toggle("show-signup");
    })
})

loginDiv.addEventListener("click",()=>{loginContainer.style.display = "flex"});

