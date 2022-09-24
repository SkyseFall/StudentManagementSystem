import axios from "axios"
import { useState } from "react"
import { useHistory } from "react-router"
import '../../adminHome.css'

const EditSubject = (props) => {
    const std = props.location.aboutProps.id.c

    const url = "http://localhost:8080"

    const history = useHistory()

    const [subjectCode, setSubjectCode] = useState("")
    const [subjectName, setSubjectName] = useState("")
    const [maxMarks, setMaxMarks] = useState(100)
    const [classs, setClasss] = useState("")
    const [maxAssignmentMarks, setMaxAssignmentMarks] = useState(20)

    const UpdateSub = () => {
        const body = {
            "subjectCode": subjectCode,
            "subjectName": subjectName,
            "std": std,
            "classs" : classs,
            "maxMarks": maxMarks,
            "maxAssignmentMarks": maxAssignmentMarks
        }
        axios.post(url + "/subject/demo", body).then(Response => {
            const result = Response.data
            if (result.status == "success") {
                window.alert("Subject " + subjectName + " is Updated successfully in class " + std)
                // history.push("/addSubject")
                history.push({
                    pathname: '/editsubject',
                    search: '?query=abc',
                    state: result.data
                })
            } else if (result.status == "exists") {
                window.alert(result.message)
            } else {
                window.alert(result.error)
            }

        })
    }

    return (
        <div className="container">

            <table>
                <tbody>

                    <tr>
                        <td>Class : </td>
                        <td>
                            <input type="text" onChange={e => { setClasss(e.target.value) }} disabled value={std} />
                        </td>
                    </tr>

                    <tr>
                        <td>Subject Code : </td>
                        <td>
                            <input type="text" onChange={e => { setSubjectCode(e.target.value) }} />
                        </td>
                    </tr>


                    <tr>
                        <td>Subject Name : </td>
                        <td>
                            <input type="text" onChange={e => { setSubjectName(e.target.value) }} />
                        </td>
                    </tr>
                    <tr>
                        <td>Total Marks : </td>
                        <td>
                            <input type="number" onChange={e => { setMaxMarks(e.target.value) }} />
                        </td>
                    </tr>
                    <tr>
                        <td>Total Assignment Marks : </td>
                        <td>
                            <input type="number" onChange={e => { setMaxAssignmentMarks(e.target.value) }} />
                        </td>
                    </tr>
                </tbody>
            </table >
            <div ><button className="button-small" onClick={UpdateSub} >Update</button></div>
        </div>
    )
}
export default EditSubject;