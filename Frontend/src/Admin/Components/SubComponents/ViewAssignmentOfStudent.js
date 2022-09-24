import axios from "axios";
import { useEffect, useState } from "react";
import { useHistory } from "react-router";

const ViewAssignmentStudent = () =>{

    const [classList,setClassList] = useState([])
    const [c,setC] = useState("1");
    const [students,setStudents] = useState([])
    const [studentId,setStudentId] = useState(0)


    const [markList,setMarkList] = useState([])

    
    const histroy = useHistory()
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

    const showSubmissions = () =>{
        const body ={
            "studentId":studentId
        }
        axios.post(url+"/marks/fetchAllById",body).then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                console.log(result.data)
                result.data.forEach(e => {
                    if(e.assignmentSolution == null){
                        e.submissionTime = "Not Submitted Yet"
                    }
                });
                setMarkList(result.data)
            }
        })
    }

    return(
        <div>This is View Assignment of Student

            Select Class : 

            <select onChange={e=>{setC(e.target.value)}}>
            {                    
                classList.map((l) =>{
                return (
                    <option value={l}>{l}</option>
                    )
                })
            }
            </select>
            <button className="button-assign" onClick={getStudents}>Show Students</button>
            <br/><br/>

            Select Student : 

            <select onChange={e=>{setStudentId(e.target.value)}}>
            <option value={0}>None</option>
            {                    
                students.map((s) =>{
                return (
                    <option value={s.studentId}>{s.studentId} : {s.sName}</option>
                    )
                })
            }
            </select>
            <button className="button-assign" onClick={showSubmissions}  >Show Submissions</button>
            <br/><br/>

            <table class="table">
                <thead>
                    <tr>
                        <th>Subject Code</th>
                        <th>Subject</th>
                        <th>Assignment Solution</th>
                        <th>Submission Time</th>
                        <th>Marks</th>
                    </tr>
                </thead>
                <tbody>
                {                    
                    markList.map((a) =>{
                    return (
                        <tr>
                            <td>{a.subjectCode}</td>
                            <td>{a.subjectName}</td>
                            <td>
                                <a href={url+"/teacherAssignment/"+a.assignmentSolution} target="_blank">Download</a>
                            </td>
                            <td>{a.submissionTime}</td>
                            <td>{a.assignmentMarks}/{a.maxAssignmentMarks}</td>
                        </tr>
                    )
                    })
                }  
                </tbody>
            </table>

        </div>
    )
}
export default ViewAssignmentStudent