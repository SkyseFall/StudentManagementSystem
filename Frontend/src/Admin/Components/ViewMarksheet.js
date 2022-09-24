import axios from "axios";
import { useEffect, useState } from "react";
import { useHistory } from "react-router";
import MarksheetRow from "./SubComponents/MarksheetRow";

const ViewMarksheet = () => {
    const [classList, setClassList] = useState([])
    const [c, setC] = useState("1");
    const [students, setStudents] = useState([])
    const [studentId, setStudentId] = useState(0)
    const [marksheet, setMarksheet] = useState("")
    const [markList, setMarkList] = useState([])




    const history = useHistory()
    const url = "http://localhost:8080"
    useEffect(() => {
        getClasses()
    }, [])

    const getClasses = () => {
        axios.get(url + "/class/getDistinctClasses").then(Response => {
            const result = Response.data
            if (result.status == "success") {
                setClassList(result.data)
            } else if (result.status == "zero") {
                window.alert(result.message)
                history.push('/AdminHome')
            }
        })

    }

    const getStudents = () => {
        const body = {
            "std": c
        }
        axios.post(url + "/users/getStudentsForClass", body).then(Response => {
            const result = Response.data
            if (result.status == "success") {
                console.log(result.data)
                setStudents(result.data)
            }
        })
    }

    const showMarksheet = () => {
        if (studentId == 0) {
            window.alert("Please select the student")
        } else {
            const body = {
                "studentId": studentId
            }
            axios.post(url + "/marks/getMarksheet", body).then(Response => {
                const result = Response.data
                if (result.status == "success") {
                    setMarksheet(result.marksheet)
                    setMarkList(result.marks)
                }
            })
        }
    }

    return (
        <div className="container">
            <div >

                Select Class :

                <select onChange={e => { setC(e.target.value) }}>
                    {
                        classList.map((l) => {
                            return (
                                <option value={l} key={l}>{l}</option>
                            )
                        })
                    }
                </select>
                <button className="button-small" onClick={getStudents}>Show Students</button>
                <br /><br />

                Select Student :

                <select onChange={e => { setStudentId(e.target.value) }}>
                    <option value={0}>None</option>
                    {
                        students.map((s) => {
                            return (
                                <option value={s.studentId} key={s.studentId}>{s.studentId} : {s.sName}</option>
                            )
                        })
                    }
                </select>
                <button className="button-delete" onClick={showMarksheet} >Show Marksheet</button>
                <br /><br />


                <hr />

                <table className="table">
                    <tbody>
                        <tr>
                            <td>Roll Number : <b>{marksheet.rollNo}</b> </td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td>Registration Id : <b>{marksheet.userId}</b></td>
                        </tr>
                        <tr>
                            <td>Class : <b>{marksheet.std}</b> </td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td>Section : <b>{marksheet.section}</b></td>
                        </tr>
                        <tr>
                            <td>Name : <b>{marksheet.studentName}</b> </td>
                        </tr>
                        <tr>
                            <td>Date of Birth : <b>{marksheet.dob}</b> </td>
                        </tr>
                        <tr>
                            <td>Gender : <b>{marksheet.gender}</b> </td>
                        </tr>
                    </tbody>
                </table>

                <br />
                <table className="table">
                    <tbody>
                        <tr>
                            <td>
                                <b>ACADEMIC PERFORMANCE</b>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <table className="table">
                    <thead>
                        <tr>
                            <th>Subject Code</th>
                            <th>Subject Name</th>
                            <th>Marks</th>
                            <th>Assignment Marks</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            markList.map((mark) => {
                                return <MarksheetRow m={mark} />
                            })
                        }
                    </tbody>
                </table>

                <br />

                <table className="table" border="solid">
                    <thead>
                        <tr>
                            <th>MARKS</th>
                            <th>TOTAL</th>
                            <th>PERCENTAGE</th>
                            <th>CLEARANCE</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><b>{marksheet.total}</b></td>
                            <td>{marksheet.maxTotal}</td>
                            <td><b>{marksheet.percentage}</b></td>
                            <td><b>{marksheet.overallStatus}</b></td>
                        </tr>
                    </tbody>
                </table>

                <br /><br />
                <br /><br />
                <br /><br />
                <br /><br />
                <br /><br />

            </div>
        </div>
    )
}
export default ViewMarksheet