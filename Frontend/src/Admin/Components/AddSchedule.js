import axios from "axios"
import { useEffect, useState } from "react"
import { useHistory } from "react-router";

const AddSchedule = () => {
    const [classList, setClassList] = useState([])
    const [c, setC] = useState("1");
    const [subjectList, setSubjectList] = useState([])
    const [subjectTeacher, setSubjectTeacher] = useState([])
    const [startTime, setStartTime] = useState("")
    const [endTime, setEndTime] = useState("")
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

    const showSubjects = () => {
        const body = {
            "std": c
        }
        axios.post(url + '/class/subjects', body).then(Response => {
            const result = Response.data
            if (result.status == "success") {
                setSubjectList(result.data)
            }
        })
    }

    const addSchedule = () => {

        const body = {
            "subjectTeacher": subjectTeacher,
            "std": c,
            "startTime": startTime + ":00",
            "endTime": endTime + ":00"
        }
        axios.post(url + '/schedule/addSchedule', body).then(Response => {
            const result = Response.data
            console.log(result);
            if (result.status == "success") {
                window.alert("schedule added successfully")
            }
        })
    }

    return (
        <div className="container ">
            <div className="adminProfile">
                <br />
                <table>
                    <tbody>
                        <tr>
                            <td> Select Class :
                                {/* <button onClick={getClasses}>Get Classes</button> */}</td>
                            <td><select onChange={e => { setC(e.target.value) }}>
                                {
                                    classList.map((l) => {
                                        return (
                                            <option key={l} value={l}>{l}</option>
                                        )
                                    })
                                }
                            </select></td>
                            <td><button className="button-show" onClick={showSubjects}>Show Subjects</button></td>
                        </tr>

                        <tr>
                            <td>Select Subject :</td>
                            <td colSpan="2"><select onChange={e => { setSubjectTeacher(e.target.value) }}>
                                <option value={""}>None</option>
                                {
                                    subjectList.map((s) => {
                                        return (
                                            <option key={s.subjectCode + " " + s.teacherId} value={s.subjectCode + " " + s.teacherId}>{s.subjectCode}-{s.subjectName}</option>
                                        )
                                    })
                                }
                            </select></td>
                        </tr>
                        <tr>
                            <td> Select Starting Time : </td>
                            <td colSpan="2"> <input onChange={e => { setStartTime(e.target.value) }} type="time" /></td>

                        </tr>
                        <tr>
                            <td>Select Ending Time : </td>
                            <td><input onChange={e => { setEndTime(e.target.value) }} type="time" /></td>
                        </tr>
                        <tr>
                            <td colSpan="3"><button className="button-show" onClick={addSchedule}>Add Schedule</button> </td>
                        </tr>
                    </tbody>
                </table>

            </div>
        </div>
    )
}

export default AddSchedule