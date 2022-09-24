import axios from "axios"
import { useEffect, useState } from "react"
import MarksRow from "./SubComponents/MarksRow"

const GiveStudentsMarks = (props) => {

    const userId = props.location.aboutProps.id.user
    const url = "http://localhost:8080"
    const [subjectList, setSubjectList] = useState([])
    const [sCode, setSCode] = useState("")
    const [studentList, setStudentList] = useState([])
    useEffect(() => {
        fetchSubjects()
        // fetchStudents()
    }, [])


    const fetchSubjects = () => {
        const body = {
            "userId": userId
        }
        axios.post(url + "/subject/fetchSubjectsForTeacher", body).then(Response => {
            console.log( "userId: "+ body.userId)
            const result = Response.data
            console.log("Resutt Subject : "+result)
            if (result.status == "success") {
                setSubjectList(result.data)
            }
        })
    }


    const fetchStudents = () => {
        if (sCode == "") {
            window.alert("please select the subject")
        } else {
            const body = {
                "subjectCode": sCode
            }
            axios.post(url + "/student/fetchStudentsByScode", body).then(Response => {
                const result = Response.data
                console.log("Resutt Marks : "+result)
                if (result.status == "success") {
                    setStudentList(result.data)
                }
            })
        }
    }


    return (
        <div className="container">
            <br />
            <div> Select Subject  </div>

            <select onChange={e => { setSCode(e.target.value) }}>
              
                <option value="">None</option>
                {
                    subjectList.map((s) => {
                        return (
                            <option value={s.subjectCode}>{s.subjectCode} - {s.subjectName} - (Class : {s.std})</option>
                        )
                    })
                }
            </select>
            <button className="button-show" onClick={fetchStudents}>Show Students</button>
            <br /><br />

            <table className="table">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Roll No.</th>
                        <th>Marks</th>
                        <th>Assignment Marks</th>
                        <th>Add Marks</th>
                        <th>Add Assignment Marks</th>
                        <th>Assignment</th>
                        <th>Submission Date</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    {
                        studentList.map((student) => {
                            return <MarksRow s={student} />
                        })
                    }
                </tbody>
            </table>
        </div>
    )
}
export default GiveStudentsMarks