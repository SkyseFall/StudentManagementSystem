import axios from "axios"
import { useState } from "react"
import { useHistory } from "react-router"
import '../../adminHome.css'

const InsertSubject = (props) => {
    const std = props.location.aboutProps.id.c

    const url = "http://localhost:8080"

    const history = useHistory()

    const [subjectCode, setSubjectCode] = useState("")
    const [subjectName, setSubjectName] = useState("")
    const [maxMarks, setMaxMarks] = useState(100)
    const [maxAssignmentMarks, setMaxAssignmentMarks] = useState(20)

    const AddSub = () => {
        const body = {
            "subjectCode": subjectCode,
            "subjectName": subjectName,
            "std": std,
            "maxMarks": maxMarks,
            "maxAssignmentMarks": maxAssignmentMarks
        }
        axios.post(url + "/subject/addSubject", body).then(Response => {
            const result = Response.data
            if (result.status == "success") {
                window.alert("Subject " + subjectName + " is added successfully in class " + std)
                history.push("/addSubject")
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
            <div ><button className="button-small" onClick={AddSub} >Add</button></div>
        </div>
    )
}
export default InsertSubject