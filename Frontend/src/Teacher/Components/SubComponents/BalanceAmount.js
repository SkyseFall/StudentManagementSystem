import axios from "axios"
import { useEffect, useState } from "react"
import { useLocation } from "react-router"

const BalanceAmount = () =>{
    const [teacherId,setTeacherId] = useState(0)
    const [designation,setDesignation] = useState("")
    const [name,setName] = useState("")
    const [dob,setDob] = useState("")
    const [mobile,setMobile] = useState("")
    const [gender,setGender] = useState("")
    const [username,setUsername] = useState("")
    const [salary,setSalary] = useState(0)

    const url = "http://localhost:8080"
    const location = useLocation()
    const userId = location.state
    useEffect(() =>{
        getTeacherPaymentDetails()
    },[])

    const getTeacherPaymentDetails = () =>{
        const body ={
            "teacherId":userId
        }
        axios.post(url+"/teacher/getTeacherPaymentDetails",body).then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                setTeacherId(result.teacherId)
                setDesignation(result.designation)
                setName(result.name)
                setDob(result.dob)
                setMobile(result.mobile)
                setGender(result.gender)
                setUsername(result.username)
                setSalary(result.salary)
            }

        })
    }
    return(
        <div className="container"> <h4 align="center">Balance Amount</h4> 
<hr></hr>
            <table className="table">
                <tbody>
                    <tr>
                        <td>Registration Id</td>
                        <td>{teacherId}</td>
                    </tr>
                    <tr>
                        <td>Name</td>
                        <td>{name}</td>
                    </tr>
                    <tr>
                        <td>Designation</td>
                        <td>{designation}</td>
                    </tr>
                    <tr>
                        <td>Date of Birth</td>
                        <td>{dob}</td>
                    </tr>
                    <tr>
                        <td>Contact number</td>
                        <td>{mobile}</td>
                    </tr>
                    <tr>
                        <td>Gender</td>
                        <td>{gender}</td>
                    </tr>
                    <tr>
                        <td>Username</td>
                        <td>{username}</td>
                    </tr>
                    <tr>
                        <td>Balance</td>
                        <td><b>{salary}</b> /- Rs</td>
                    </tr>
                </tbody>
            </table>

        </div>
    )
}
export default BalanceAmount