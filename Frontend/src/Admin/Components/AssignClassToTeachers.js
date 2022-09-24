import axios from "axios"
import { useEffect, useState } from "react"
import SubWithTeacher from "./SubComponents/SubWithTeacher"

const AssignClassToTeachers = () =>{

    const [subjectList,setSubjectList] = useState([])

    useEffect(() =>{
        getAllSubjects()
    },[])

    const url = "http://localhost:8080"
    const getAllSubjects = () =>{
        axios.post(url+"/subject/all").then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                setSubjectList(result.data)
            }
        })
    }
    return (
        <div className="container">
            <table class="table">
                <thead>
                    <tr>
                        <th>Subject Code</th>
                        <th>Subject Name</th>
                        <th>Class</th>
                        <th>Teacher Assigned</th>
                        <th>Select Teacher</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    {
                        subjectList.map((subject) =>{
                            return <SubWithTeacher s={subject} />
                        })
                    }
                </tbody>
            </table>



        </div>
    )
}

export default AssignClassToTeachers