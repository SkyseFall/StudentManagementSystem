import axios from "axios"
import { useEffect, useState } from "react"
import { useLocation, useHistory } from "react-router"

const EditStudentClass = () =>{
    const location = useLocation()
    const histroy = useHistory()
    const student = location.state

    const url = "http://localhost:8080"

    const [std,setStd] = useState(student.std)
    const [section,setSection] = useState(student.section)

    useEffect(() =>{
        Defaults()
    },[])

    function Defaults (){
        //console.log(data.firstName)
        document.getElementById("Class").defaultValue = student.std
        document.getElementById("std").defaultValue = student.section
        
    }

    const assignClass = () =>{
        const body = {
            "studentId" : student.studentId,
            "std" : std,
            "section" : section,
            "rollNo" : student.rollNo
        }
        console.log(body)
        axios.post(url+"/student/addClass",body).then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                window.alert("Class "+std+" assigned successfully to student "+student.studentName)
                histroy.push("/AssignClassToStudents")
            }
        })
    }

    return (
        <div>This is EditStudentClass
            <table>
                <tr>
                    <td>Student Id : </td>
                    <td>
                        <input type="text" disabled value={student.studentId}  />
                    </td>
                </tr>
                <tr>
                    <td>Student Name : </td>
                    <td>
                    <input type="text" disabled value={student.studentName} />
                    </td>
                </tr>
                <tr>
                    <td>roll No. : </td>
                    <td>
                    <input type="text" disabled value={student.rollNo} />
                    </td>
                </tr>
                <tr>
                    <td>Class : </td>
                    <td>
                    <input type="text" id="Class" onChange={e=>{setStd(e.target.value)}} />
                    </td>
                </tr>
                <tr>
                    <td>Section : </td>
                    <td>
                    <input type="text" id="std" onChange={e=>{setSection(e.target.value)}}/>
                    </td>
                </tr>
            </table>
            <button onClick={assignClass}>Assign</button>
        </div>
    )
}
export default EditStudentClass