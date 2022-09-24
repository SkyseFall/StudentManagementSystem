import axios from "axios";
import { useEffect, useState } from "react";
import MarksheetRow from "./SubComponents/MarksheetRow";

const ViewMarksheet = (props) => {
    const userId = props.location.aboutProps.id.user
    const [marksheet, setMarksheet] = useState("")
    const [markList, setMarkList] = useState([])

    const url = "http://localhost:8080"
    useEffect(() => {
        console.log("UserID: "+userId)
        console.log("markList: "+markList)
        showMarksheet()
    }, [])


    const showMarksheet = () => {

        const body = {
            "studentId": userId
        }
        console.log("User body : "+body)
        axios.post(url + "/marks/getMarksheet", body).then(Response => {
           
            const result = Response.data
            console.log("User Result  : "+result)
            if (result.status == "success") {
                setMarksheet(result.marksheet)
                setMarkList(result.marks)
            }
        })
    }

    return (
        <div className="container">
            <h3 align="center">MARKSHEET</h3>
            <hr />
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
                        <td>className : <b>{marksheet.std}</b> </td>
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
            <br />
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
    )
}
export default ViewMarksheet