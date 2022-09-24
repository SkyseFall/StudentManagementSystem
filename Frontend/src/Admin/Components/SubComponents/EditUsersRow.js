import axios from "axios"
import { useState } from "react"
import { useHistory } from "react-router";
import '../../adminHome.css'
const EditUsersRow = ({ u }) => {
    
    const [user, setUser] = useState()
    const histroy = useHistory();


    const EditParticularUser = () => {
        const body = {
            "email": u.email
        }
        if (u.typeJob == "student" || u.typeJob == "Student") {
            const url = "http://localhost:8080"
            axios.post(url + "/student/getProfile", body).then(Response => {
                const result = Response.data
                if (result.status == "success") {
                    setUser(result.data)
                    //console.log(result.data)
                    histroy.push({
                        pathname: '/studentProfile',
                        search: '?query=abc',
                        state: result.data
                    })
                }
            })
        }
        if (u.typeJob == "teacher" || u.typeJob == "Teacher") {
            const url = "http://localhost:8080"
            axios.post(url + "/teacher/getProfile", body).then(Response => {
                const result = Response.data
                if (result.status == "success") {
                    setUser(result.data)
                    //console.log(result.data)
                    histroy.push({
                        pathname: '/teacherProfile',
                        search: '?query=abc',
                        state: result.data
                    })
                }
            })
        }
    }
    return (
        <tr>
            <td>{u.firstName}</td>
            <td>{u.lastName}</td>
            <td>{u.typeJob}</td>
            <td>{u.email}</td>
            <td>{u.mobile}</td>
            <td>
                <button className="button-edit" onClick={EditParticularUser} >Edit</button>
            </td>
        </tr>
    )
}
export default EditUsersRow