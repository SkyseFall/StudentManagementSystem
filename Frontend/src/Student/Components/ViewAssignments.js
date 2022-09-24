import axios from "axios"
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import TeacherAssignmentUploades from "./SubComponents/TeacherAssignmentUploades";

const ViewAssignments = (props) => {
    const userId = props.location.aboutProps.id.user
    const [rows, setRows] = useState([])

    useEffect(() => {
        getAssignment()
    }, [])


    const url = "http://localhost:8080"

    const getAssignment = () => {

        const body = {
            "studentId": userId
        }
        axios.post(url + "/teacherAssignment/studentId/fetchList", body).then(Response => {
            const result = Response.data
            if (result.status == "success") {
                setRows(result.data)
                console.log(result.data)
                console.log(userId)
            }
        })


    }
    return (
        <div className="container">

            <div className="nav-item" id="login" >
                {/* <NavLink onClick={change} className="nav-link" to="/login">Login</NavLink> */}
                <Link className="nav-link" to="/errorPageMsg">
                    <button type="button" className="btn btn-primary">Submit Assignment</button>
                </Link>
            </div>

            <table className="table table-responsive">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Subject Code</th>
                        <th>Subject Name</th>
                        <th>Due Date</th>
                        <th>Submission Time</th>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    {
                        rows.map((row) => {
                            return (

                                <TeacherAssignmentUploades r={row} />
                            )
                        })
                    }
                </tbody>
            </table>
        </div>
    )
}
export default ViewAssignments