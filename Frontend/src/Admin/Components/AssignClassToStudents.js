import axios from "axios"
import { useEffect, useState } from "react"
import StudentRow from "./SubComponents/StudentRow"

const AssignClassToStudents = () =>{

    const [studentList,setStudentList] = useState([])
    const url = "http://localhost:8080"

    useEffect(() =>{
        getAllStudents()
    },[])


    const getAllStudents = () =>{
        axios.post(url+"/users/getAllStudents").then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                setStudentList(result.data)
            }
        })
    }
    return (
        <div className="container">
            <table class="table">
                <thead className="tableHead">
                    <tr>
                        <th>Student Id</th>
                        <th>Roll no.</th>
                        <th>Student Name</th>
                        <th>Class</th>
                        <th>Section</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    {
                        studentList.map((student) =>{
                            return <StudentRow s={student} />
                        })
                    }
                </tbody>
            </table>
        </div>
    )
}

export default AssignClassToStudents