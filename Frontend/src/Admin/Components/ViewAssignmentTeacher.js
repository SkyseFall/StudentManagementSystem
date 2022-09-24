import axios from "axios"
import { useEffect, useState } from "react"
import TeacherAssignmentUploades from "./SubComponents/TeacherAssignmentUploades"

const ViewAssignmentTeacher = () =>{
    const [teachers,setTeachers] = useState([])
    const [teacherId,setTeacherId] = useState(0)
    const [rows,setRows] = useState([])

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
    }

    const getAssignment = () =>{
        if(teacherId == 0){
            window.alert("Please select the teacher")
        }else{
            const body = {
                "teacherId":teacherId
            }
            axios.post(url+"/teacherAssignment/all/fetchList",body).then(Response =>{
                const result = Response.data
                if(result.status == "success"){
                    setRows(result.data)
                    console.log(result.data)
                }
            })
        }
        
    }

    return(
        <div className="container">
            <br/><br/>
            Select Teacher : 

            <select onChange={e=>{setTeacherId(e.target.value)}}>
            <option value={0}>None</option>
            {                    
                teachers.map((t) =>{
                return (
                    <option value={t.teacherId}>{t.teacherId} - {t.teacherName}</option>
                    )
                })
            }
            </select>
            <button className="button-small" onClick={getAssignment}>Show</button>
            <br/><br/>

            <table class="table">
                <thead>
                    <tr>
                        <th>Class</th>
                        <th>Assignment Id</th>
                        <th>Subject Code</th>
                        <th>Subject Name</th>
                        <th>Due Date</th>
                        <th>Submission Time</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                {                    
                    rows.map((row) =>{
                    return (
                            <TeacherAssignmentUploades r={row} />
                        )
                    })
                }
                </tbody>
            </table>
        </div>
    )
}
export default ViewAssignmentTeacher