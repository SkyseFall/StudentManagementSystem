import axios from "axios";
import { useState } from "react";
import {useHistory,useLocation} from 'react-router-dom'
import './login.css';
const UpdatePassword = () =>{
    const [pass1,setPass1] = useState(1)
    const [pass2,setPass2] = useState(2)
    const history = useHistory()
    const location = useLocation()
    const data = location.state
    const Verify = () =>{
        if(pass1 == pass2){
            const body ={
                "userId" : data,
                "password" : pass1
            }
            const url = "http://localhost:8080"
            axios.post(url+"/users/updatePassword",body).then(Response =>{
                const result = Response.data
                if(result.status == "success"){
                    window.alert(result.message)
                    history.push('/Login')
                }else if (result.status == "error"){

                }
            })
        }else{
            alert("Password dosen't match.Please try again.")
        }
    }

    return (
        <body class="body">
    <div class="center">
    <h1 class="head">Set New Password</h1>
    
    <form method="#">
      <div class="txt_field">
      <input onChange={e=>{setPass1(e.target.value)}} type="password" name="pass1" />
        <span></span>
        <label>New Password</label>
      </div>
      <div class="txt_field">
      <input onChange={e=>{setPass2(e.target.value)}} type="password" name="pass2" />
        <span></span>
        <label>Confirm</label>
      </div>
     
      <button type="button" onClick={Verify}>Change</button>
      
    </form>
  </div>
  
</body>
    )
}
export default UpdatePassword;