import axios from "axios"
import { useState } from "react"
import { useHistory } from "react-router"

const TeacherDesignationRow = ({t}) =>{
    const [designation,setDesignation] = useState("")
    const url = "http://localhost:8080"

    const histroy = useHistory()

    const saveDesignation = () =>{
        const body = {
            "teacherId":t.teacherId,
            "designation":designation
        }
        axios.post(url+"/teacher/changeDesignation",body).then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                window.alert(result.messege)
                histroy.push('/AdminHome')
            }
        })
    }

    return (
        <tr>
            <td>{t.teacherId}</td>
            <td>{t.teacherName}</td>
            <td>{t.email}</td>
            <td>{t.mobile}</td>
            <td>{t.designation}</td>
            <td>
                <input type="text" onChange={e=>{setDesignation(e.target.value)}} />
            </td>
            <td>
                <button className="button-small" onClick={saveDesignation} >Change</button>
            </td>
        </tr>
    )
}

export default TeacherDesignationRow
