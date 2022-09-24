import axios from "axios"
import { useEffect, useState } from "react"
import { useHistory } from "react-router";

const AddAssignment = (props) => {

    const userId = props.location.aboutProps.id.user

    const [subjectList, setSubjectList] = useState([])

    const [subjectC, setSubjectC] = useState(0)

    const histroy = useHistory();
    const url = "http://localhost:8080"

    const [c, setC] = useState("1");
    const [assignmentDueDate, setAssignmentDueDate] = useState("")
    const [assignmentFile, setAssignmentFile] = useState(undefined)
    const [assId, setAssId] = useState(0)

    useEffect(() => {
        getClasses()
    }, [])


    const [classList, setClassList] = useState([])


    const getClasses = () => {
        axios.get(url + "/class/getDistinctClasses").then(Response => {
            const result = Response.data
            if (result.status == "success") {
                setClassList(result.data)
            } else if (result.status == "zero") {
                window.alert(result.message)
                histroy.push('/TeacherHome')
            }
        })



    }

    const SubjectsRow = () => {
        const body = {
            "std": c
        }
        axios.post(url + "/class/subjects", body).then(Response => {
            const result = Response.data
            //console.log(Response.data)
            if (result.status == "success") {
                //console.log(result.data)
                setSubjectList(result.data)
            }
        })
        //console.log(subjectList)
    }
    function addData(Id) {
        console.log(Id)
        const body = {
            "teacherId": userId,
            "assignmentDue": assignmentDueDate,
            "subjectCode": subjectC,
            "assignmentId": Id
        }
        console.log(body)
        axios.post(url + "/teacherAssignment/addAssignmentDetails", body).then(Response => {
            const result = Response.data
            if (result.status === 'success') {
                histroy.push("/TeacherHome")
            } else {
                alert("something went wrong while adding data")
            }
        })
    }
    const sendData = () => {
        window.alert(Date().toLocaleString())
        window.alert(assignmentDueDate.toLocaleString())
        if (Date() < assignmentDueDate) {
            window.alert("OK")
        } else {
            window.alert("Not Ok")
        }

        // if(subjectC != 0 && assignmentFile != undefined){
        //     const data = new FormData()
        //     data.append('teacher_id',userId)
        //     data.append('added_assignment',assignmentFile)
        //     data.append('assignment_due',assignmentDueDate)
        //     data.append('s_code',subjectC)

        //     console.log(data)

        //     axios.post(url+"/teacherAssignment/addAssignment",data).then(Response =>{
        //         const result = Response.data
        //         if (result.status === 'success') {
        //             console.log(result.data)
        //             setAssId(result.data)
        //             addData(result.data)
        //             alert("File uploaded successfully")
        //         }else{
        //             alert("something went wrong while uploading a file")
        //         }
        //     })
        // }
        // console.log("IamHete   "+assId)


    }



    return (

        <div className="container">
            <b><h5>Add assignment</h5>  </b>
            <br />
            <table>
                <tbody>
                    <tr>
                        <td>Select Class :</td>
                        <td><select onChange={e => { setC(e.target.value) }}>
                            {
                                classList.map((l) => {
                                    return (
                                        <option value={l} key={l}>{l}</option>
                                    )
                                })
                            }
                        </select></td>
                        <td><button className="button-show" onClick={SubjectsRow}>Show</button></td>

                    </tr>
                </tbody>
            </table>
            <hr />

            <table className="table">
                <thead className="tableHead">
                    <tr >
                        <th>Subject Code</th>
                        <th>Subject Name</th>
                        <th>Total Marks</th>
                        <th>Total Assignment Marks</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    {
                        subjectList.map((subject) => {
                            return <tr >
                                <td>{subject.subjectCode}</td>
                                <td>{subject.subjectName}</td>
                                <td>{subject.maxMarks}</td>
                                <td>{subject.maxAssignmentMarks}</td>
                                <td>
                                    <button className="button-edit" onClick={() => setSubjectC(subject.subjectCode)}>
                                        Select
                                    </button>
                                </td>
                            </tr>
                        })
                    }
                </tbody>
            </table>
            <br />
            <br />
            <hr />



            <b><h4>Please Check the following Credentials Before uploading Assignment !!</h4></b>
            <br /><br />
            <table>
                <tbody>
                    <tr>
                        <td colSpan="2">Add Assignment for subject with subject code "<b> {subjectC} </b>" for class " <b>{c}</b> " : </td>
                    </tr>
                    <tr>
                        <td> Upload the file : </td>
                        <td> <input type="file" onChange={e => { setAssignmentFile(e.target.files[0]) }} /></td>


                    </tr>
                    <tr>
                        <td> Select Due Date for assignment :</td>
                        <td><input type="date" onChange={e => { setAssignmentDueDate(e.target.value) }} /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td> <button className="button-small" onClick={sendData} >Upload</button></td>
                    </tr>
                </tbody>
            </table>




            <br /><br />
            {assignmentDueDate}
            <br /><br />
            <br /><br />



        </div>
    )
}

export default AddAssignment