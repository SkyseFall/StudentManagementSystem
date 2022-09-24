import axios from "axios"
import { useEffect, useState } from "react"
import { useHistory } from "react-router"
import StudentAttendanceRow from "./SubComponents/StudentAttendanceRow"

const TakeStudentAttendance = () =>{
    const [classList,setClassList] = useState([])
    const [c,setC] = useState("1");
    const [studentList,setStudentList] = useState([])
    const history = useHistory()
    const url = "http://localhost:8080"
     useEffect(() =>{
         getClasses()
     },[])

    const getClasses = () =>{
        axios.get(url+"/class/getDistinctClasses").then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                setClassList(result.data)
            }else if(result.status == "zero"){
                window.alert(result.message)
                history.push('/TeacherHome')
            }
        })
            
    }

    const getStudents = () =>{
        const body ={
            "std" : c
        }
        axios.post(url+'/student/getStudentsForAttendance',body).then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                setStudentList(result.data)
            }
        })
    }

    return (
        <div className="container"><h4>StudentAttendance</h4>
            <tr>
                <td> Select Class :</td>
                <td><select onChange={e=>{setC(e.target.value)}}>
            {                    
                classList.map((l) =>{
                return (
                    <option value={l} key={l}>{l}</option>
                    )
                })
            }
            </select></td>
                <td><button className="button-show" onClick={getStudents}>Show</button></td>
            </tr>
        
            <br/>
            
            <table className="table">
                <thead>
                    <tr>
                        <th>Student Id</th>
                        <th>Student Name</th>
                        <th>Section</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    {
                        studentList.map((sl) =>{
                            return <StudentAttendanceRow s={sl} />
                        })
                    }  
                </tbody>
            </table>
        </div>
    )
}
export default TakeStudentAttendance