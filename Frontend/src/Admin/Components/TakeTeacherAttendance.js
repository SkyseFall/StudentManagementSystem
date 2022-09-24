import axios from "axios"
import { useEffect, useState } from "react"
import TeacherAttendanceRow from "./SubComponents/TeacherAttendanceRow"

const TakeTeachersAttendance = () =>{
    const [teacherList,setTeacherList] = useState([])
    useEffect(() =>{
        getTeachers()
    },[])
    const url = "http://localhost:8080"
    const getTeachers = () =>{
        axios.post(url+'/teacher/getTeachersForAttendance').then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                setTeacherList(result.data)
            }
        })
    }

    return (
        <div className="container">

            <table class="table">
                <thead>
                    <tr>
                        <th>Teacher Id</th>
                        <th>Teacher Name</th>
                        <th>Designation</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    {
                        teacherList.map((tl) =>{
                            return <TeacherAttendanceRow t={tl} />
                        })
                    }  
                </tbody>
            </table>
        </div>
    )
}
export default TakeTeachersAttendance