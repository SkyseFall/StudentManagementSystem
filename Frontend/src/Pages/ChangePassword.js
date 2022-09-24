import axios from "axios";
import { useState } from "react";
import {useHistory} from 'react-router-dom'
import './login.css';
const ChangePassword = () =>{
    const [dob,setDob] = useState("1111-11-11");
    const [email,setEmail] = useState("");
    const history = useHistory()
    const Change = () =>{
        const body ={
            "email" : email,
            "dob" : dob
        }
        const url = "http://localhost:8080"
            axios.post(url+"/users/changePassword",body).then(Response =>{
                const result = Response.data
                if(result.status == "success"){
                    //history.push('/UpdatePassword')
                    history.push({
                        pathname:'/UpdatePassword',
                        search: '?query=abc',
                        state: result.data
                    })
                }else{
                    var err = document.getElementById("showError")
                    err.innerHTML = result.error
                }
            })
    }

    return( <body class="body">
    <div class="center">
    <h1 class="head">Trouble Logging In?</h1>
    <div class="head2">Enter your email and birth date to verify!!</div>
    <form method="#">
      <div class="txt_field">
      <input onChange={e=>{setEmail(e.target.value)}} required type="email" name = "email"/>
        <span></span>
        <label>Email</label>
      </div>
      <div class="txt_field">
      <input onChange={e=>{setDob(e.target.value)}} required type="date" name = "mobile"/>
        <span></span>
        <label>Date of birth</label>
      </div>
      <div id="showError"></div>
     
      <button type="button"  onClick ={Change}>Verify</button>
      
    </form>
  </div>
  
</body>
        
    )
}
export default ChangePassword;