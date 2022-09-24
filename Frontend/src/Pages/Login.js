import React from 'react'
import axios from "axios";
import { useState } from "react";
import { Link, useHistory } from 'react-router-dom'
import './login.css';


const Login = () => {

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [typeJobHook, setTypeJob] = useState("");

    const histroy = useHistory();

    function Goto(typeJob, user) {
        if (typeJob == "admin"  ||  typeJob == "Admin") {
            console.log(user)
            //console.log(typeJob)
            histroy.push({
                pathname: '/AdminHome',
                search: '?query=abc',
                state: user
            })
        }
        if (typeJob == "teacher"  || typeJob == "Teacher") {
            console.log(user)
            //console.log(typeJob)
            histroy.push({
                pathname: '/TeacherHome',
                search: '?query=abc',
                state: user
            })
        }
        if (typeJob == "student" || typeJob == "Student") {
            console.log(user)
            //console.log(typeJob)
            histroy.push({
                pathname: '/StudentHome',
                search: '?query=abc',
                state: user
            })
        }
    }

    const login = () => {
        const body = {
            'email': email,
            'password': password
        }
        const url = "http://localhost:8080"
        axios.post(url + "/users/login", body).then(Response => {
            const result = Response.data
            if (result.status == "success") {
                setTypeJob(result.data)
                console.log(result)
                //console.log(result.user)
                Goto(result.data, result.user)
            } else if (result.status == "inactive") {
                window.alert(result.error)
            }
            else {
                window.alert(result.error)
            }
        })
    }

    return (



        <div className="body">
            <div className="center">
                <h1>Login</h1>
                <form method="#">
                    <div className="txt_field">
                        <input type="email" required onChange={e => { setEmail(e.target.value) }} />
                        <span></span>
                        <label>Email</label>
                    </div>
                    <div className="txt_field">
                        <input type="password" onChange={e => { setPassword(e.target.value) }} required />
                        <span></span>
                        <label>Password</label>
                    </div>
                    <div className="pass"><Link to="/ChangePassword">Forgot Password</Link></div>
                    <button type="button" onClick={login}>Login</button>
                    <div className="signup_link">
                        Not a member? <Link to="/register">Register Here</Link>
                    </div>
                </form>
            </div>

        </div>
    );
}

export default Login;