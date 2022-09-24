import axios from "axios";
import { useState } from "react";
import {useHistory} from 'react-router-dom'
import './register.css'

const Register = () =>{

        const [firstName,setFirstName] = useState("");
        const [lastName,setLastName] = useState("");
        const [dob,setDob] = useState("2020-01-01");
        const [mobile,setMobile] = useState(0);
        const [gender,setGender] = useState("");
        const [username,setUsername] = useState("");
        const [email,setEmail] = useState("");
        const [password,setPassword] = useState("");
        const [typeJob,setTypeJob] = useState("");
        const [pincode,setPincode] = useState(0);
        const [locality,setLocality] = useState("");

        const history = useHistory()
        const body ={
            "firstName" : firstName,
            "lastName" : lastName,
            "dob" : dob,
            "mobile" : mobile,
            "gender" : gender,
            "username" : username,
            "email" : email,
            "password" : password,
            "typeJob" : typeJob,
            "pincode" : pincode,
            "locality" : locality
        }

        const Register = () => {
            const url = "http://localhost:8080"
            if(typeJob != ""){
              axios.post(url+"/users/register",body).then(Response =>{
                const result = Response.data
                if(result.status == "success"){
                    window.alert("Registration Successful")
                    history.push('/Login')
                }else if(result.status == "exist"){
                  window.alert(result.messege)
                  history.push('/register')
                }
              })
            }else{
              window.alert("Please select your Role,Try again..")
              history.push('/register')
            }
        }

    return (
       <body class="body">
        <div class="container-register">
        <div class="title">Registration</div>
        <div class="content">
          <form action="/register">
            <div class="user-details">
              <div class="input-box">
                <span class="details">First FirstName</span>
                <input type="text" placeholder="Enter your name" required onChange={e=>{setFirstName(e.target.value)}}/>
              </div>
              <div class="input-box">
                <span class="details">Last Name</span>
                <input type="text" placeholder="Enter your lastName" required onChange={e=>{setLastName(e.target.value)}} />
              </div>
              <div class="input-box">
                <span class="details">Username</span>
                <input type="text" placeholder="Enter your pincode" required onChange={e=>{setUsername(e.target.value)}} />
              </div>
              <div class="input-box">
                <span class="details">DOB</span>
                <input type="date" placeholder="Enter date of birth" required onChange={e=>{setDob(e.target.value)}}/>
              </div>
              <div class="input-box">
                <span class="details">Phone Number</span>
                <input type="text" placeholder="Enter your number" required onChange={e=>{setMobile(e.target.value)}}/>
              </div>
              <div class="input-box">
                <span class="details">Email</span>
                <input type="text" placeholder="Enter your email" required onChange={e=>{setEmail(e.target.value)}}/>
              </div>
              <div class="input-box">
                <span class="details">Password</span>
                <input type="password" placeholder="Enter your password" required onChange={e=>{setPassword(e.target.value)}} />
              </div>
              <div class="input-box">
                <span class="details">PinCode</span>
                <input type="text" placeholder="Enter your pincode" required onChange={e=>{setPincode(e.target.value)}} />
              </div>
              
              <div class="input-box">
              <span class="details">select role</span>
                <select id="typejob" name="typejob" onChange={e=>{setTypeJob(e.target.value)}}>
                    <option value="">-</option>
                    <option value="admin">Admin</option>
                    <option value="student">Student</option>
                    <option value="teacher">Teacher</option>
                    </select>
              </div>
              <div class="input-box">
                <span class="details">Address</span>
                <input type="text" placeholder="Enter your Address" required onChange={e=>{setLocality(e.target.value)}} />
              </div>
            </div>
            
            <div class="gender-details"  >
              <input type="radio" name="gender" id="dot-1" value="male" onChange={e=>{setGender(e.target.value)}}/>
              <input type="radio" name="gender" id="dot-2"value="female" onChange={e=>{setGender(e.target.value)}}/>
              <input type="radio" name="gender" id="dot-3"value="other" onChange={e=>{setGender(e.target.value)}}/>
              <span class="gender-title">Gender</span>
              <div class="category">
                <label for="dot-1">
                <span class="dot one"></span>
                <span class="gender"> Male </span>
              </label>
              <label for="dot-2">
                <span class="dot two"></span>
                <span class="gender">Female </span>
              </label>
              <label for="dot-3">
                <span class="dot three"></span>
                <span class="gender">Other </span>
                </label>
              </div>
            </div>
            <div class="button-register">
              
            <button onClick={Register}>Register</button>
            </div>
          </form>
        </div>
      </div>
      </body> 
    )
}
export default Register;