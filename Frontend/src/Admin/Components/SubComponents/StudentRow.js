import { useHistory } from "react-router"

const StudentRow = ({s}) =>{
    const student = s
    const history = useHistory()

    const AssignClass = () =>{
        console.log("i am here for "+ student)
        history.push({
            pathname:'/EditStudentClass',
            search: '?query=abc',
            state: student
        })
    }

    return (
        <tr>
            <td>{s.studentId}</td>
            <td>{s.rollNo}</td>
            <td>{s.studentName}</td>
            <td>{s.std}</td>
            <td>{s.section}</td>
            <td>
                <button className="button-assign" onClick={AssignClass}>Assign Class</button>
            </td>
        </tr>
    )
}

export default StudentRow