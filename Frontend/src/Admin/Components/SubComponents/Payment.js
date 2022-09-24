import axios from "axios"
import { useEffect, useState } from "react"
import { useHistory } from "react-router"

const Payment = () =>{
    const [balance,setBalance] = useState(0)
    const [teachers,setTeachers] = useState([])
    const [teacher,setTeacher] = useState(0)
    const [amount,setAmount] = useState(0)

    const history = useHistory()

    useEffect(() =>{
        getAllTeachers()
    },[])


    const url = "http://localhost:8080"
    const getAllTeachers = () =>{
        axios.post(url+"/teacher/all").then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                setTeachers(result.data)
            }
        })
        axios.get(url+"/users/getBalance").then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                setBalance(result.data)
            }
        })
    }

    const payTeacher = () =>{
        if(amount > balance){
            window.alert("Insufficient Balance")
        }else if(teacher == 0){
            window.alert("Please select the teacher")
        }else if(amount == 0){
            window.alert("Please enter the amount")
        }else{
            const body ={
                "teacherId":teacher,
                "salary":amount
            }
            axios.post(url+"/users/payTeacher",body).then(Response =>{
                const result = Response.data
                if(result.status == "success"){
                    window.alert("Transaction Successful")
                    history.push("/AdminHome")
                }else{
                    window.alert("Some Problem has occured on our side please try again later")
                    history.push("/AdminHome")
                }
            })
        }
    }

    return(
        <div className="container ">
            <div className="adminProfile">
            <table>
                <tr>
                    <td colSpan="2">
                    Current Balance in Schools account is <b>{balance}</b> /- Rs.
                    </td>
                </tr>
                <tr>
                    <td>Select Teacher :
                    </td>
                    <td><select onChange={e=>{setTeacher(e.target.value)}}>
                        <option value={0}>None</option>
                        {                    
                            teachers.map((t) =>{
                            return (
                                <option value={t.teacherId}>{t.teacherId} : {t.teacherName} ({t.designation})</option>
                                )
                            })
                        }
                        </select></td>
                </tr>
                <tr>
                    <td colSpan="2">Please Enter the amount you want to pay</td>
                </tr>
                <tr>
                    <td>Amount </td>
                    <td>
                        <input required type="number" onChange={e=>{setAmount(e.target.value)}} /> /- Rs.
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td ><button className="button-edit" onClick={payTeacher}>Pay</button></td>
                </tr>
            </table>
           <br/>
            </div>

        </div>
    )
}
export default Payment