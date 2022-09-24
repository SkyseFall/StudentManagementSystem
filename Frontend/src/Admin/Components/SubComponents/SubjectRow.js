import axios from "axios"
import { useState } from "react"
import { useHistory } from "react-router";


const SubjectRow = ({ s }) => {

    const [user, setUser] = useState()
    const histroy = useHistory();


    const EditSubject = () => {
        const body = {
            "subject_code": s.subject_code
        }
        if (s.typeJob == "admin" || s.typeJob == "Admin" || s.typeJob == "teacher" || s.typeJob == "Teacher") {
            const url = "http://localhost:8080"
            axios.post(url + "/subject/addSubject", body).then(Response => {
                const result = Response.data
                if (result.status == "success") {
                    setUser(result.data)
                    //console.log(result.data)
                    histroy.push({
                        pathname: '/editSubject',
                        search: '?query=abc',
                        state: result.data
                    })
                }
            })
        }

    }

    return (
        <tr>
            <td>{s.subjectCode}</td>
            <td>{s.subjectName}</td>
            <td>{s.maxMarks}</td>
            <td>{s.maxAssignmentMarks}</td>
            <td>{s.teacherName}</td>

            <td>
                <button className="button-edit" onClick={EditSubject} >Edit</button>
            </td>
        </tr>
    )
}
export default SubjectRow