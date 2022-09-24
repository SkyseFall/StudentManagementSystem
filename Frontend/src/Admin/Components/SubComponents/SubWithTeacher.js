import axios from "axios"
import { useEffect, useState } from "react"
import { useHistory } from "react-router"

const SubWithTeacher = ({s}) =>{

    const [teacherList,setTeacherList] = useState([])
    const [teacherId,setTeacherId] = useState(0)
    const history = useHistory()
    const url = "http://localhost:8080"

    useEffect(() =>{
        fetchData()
    },[])

    const fetchData = () =>{
        axios.post(url+"/teacher/getNameAndId").then(Request =>{
            const result = Request.data
            if(result.status == "success"){
                setTeacherList(result.data)
            }
        })
    }

    const AssignTeacher = () =>{
        const body ={
            "subjectCode" : s.subjectCode,
            "teacherId" : teacherId
        }
        axios.post(url+"/subject/AssignTeacher",body).then(Request =>{
            const result = Request.data
            if(result.status == "success"){
                window.alert("Teacher is added to the subject "+s.subjectName)
                history.push('/AdminHome')
            }
        })
    }

    return (
        <tr>
            <td>{s.subjectCode}</td>
            <td>{s.subjectName}</td>
            <td>{s.std}</td>
            <td>{s.tName}</td>
            <td>
                        <select onChange={e=>{setTeacherId(e.target.value)}} >
                            <option value="0">None</option>
                                {
                                    //console.log(students)
                                    
                                    teacherList.map((t) =>{
                                        return (
                                            <option value={t.teacherId}>{t.teacherName} ({t.designation}) </option>
                                        )
                                    })
                                }
                        </select>
            </td>
            <td>
                <button className="button-assign" onClick={AssignTeacher}>Assign</button>
            </td>
        </tr>
    )
}

export default SubWithTeacher