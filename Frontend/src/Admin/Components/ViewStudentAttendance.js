import axios from "axios";
import { useEffect, useState } from "react";
import { useHistory } from "react-router";

const ViewStudentAttendance = () =>{

    const [classList,setClassList] = useState([])
    const [c,setC] = useState("1")
    const [students,setStudents] = useState([])
    const [studentId,setStudentId] = useState(0)
    const [attendanceList,setAttendanceList] = useState([])
    const [percentage,setPercentage] = useState(0)

    const history = useHistory()

    const url = "http://localhost:8080"
     useEffect(() =>{
         getClasses()
     },[])

    const getClasses = () =>{
        axios.get(url+"/class/getDistinctClasses").then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                setClassList(result.data)
            }else if(result.status == "zero"){
                window.alert(result.message)
                history.push('/AdminHome')
            }
        })
            
    }

    const getStudents = () =>{
        const body ={
            "std":c
        }
        axios.post(url+"/users/getStudentsForClass",body).then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                console.log(result.data)
                setStudents(result.data)
            }
        })
    }

    const getStudentAttendance = () =>{
        if(studentId == 0){
            window.alert("Please Select the student")
        }else{
            const body ={
                "studentId":studentId
            }
            axios.post(url+"/studentAttendance/getStudentAttendance",body).then(Response =>{
                const result = Response.data
                if(result.status == "success"){
                    setAttendanceList(result.data)
                    setPercentage(result.percentage)
                }else{
                    window.alert(result.error)
                    setAttendanceList([])
                    setPercentage("Not Available")
                }
            })
        }
    }

    return(
        <div className="container">
            <table>
                <tr>
                    <td>Select Class : </td>
                    <td><select onChange={e=>{setC(e.target.value)}}>
            {                    
                classList.map((l) =>{
                return (
                    <option value={l}>{l}</option>
                    )
                })
            }
            </select></td>
                    <td><button className="button-show" onClick={getStudents} >Show Students</button></td>
                    
                </tr>
                <tr>
                    <td> Select Student : </td>
                    <td><select onChange={e=>{setStudentId(e.target.value)}}>
            <option value={0}>None</option>
            {                    
                students.map((s) =>{
                return (
                    <option value={s.studentId}>{s.studentId} : {s.sName}</option>
                    )
                })
            }
            </select></td>
                    <td><button className="button-show" onClick={getStudentAttendance} >Show Attendance</button></td>
                    
                </tr>
            </table>
            
            <table class="table">
                <thead>
                    <tr>
                        <th>Date</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                {                    
                    attendanceList.map((a) =>{
                    return (
                        <tr>
                            <td>{a.date}</td>
                            <td>{a.status}</td>
                        </tr>
                    )
                    })
                }
                </tbody>
            </table>
            <br/><br/>
            <br/><br/>
            <br/><br/>
            Present Percentage = <b>{percentage}</b>%
            <br/><br/>
            <br/><br/>
            <br/><br/>
            <br/><br/>
        </div>
    )
}
export default ViewStudentAttendance