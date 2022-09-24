import axios from "axios"
import { useEffect, useState } from "react"
import TeacherDesignationRow from "./SubComponents/TeacherDesignationRow"

const AssignRole = () =>{
    const [teachers,setTeachers] = useState([])
    const [teacherName,setTeacherName] = useState("")

    useEffect(() =>{
        getAllTeachers()
    },[])


    const url = "http://localhost:8080"
    const getAllTeachers = () =>{
        axios.post(url+"/teacher/all").then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                setTeachers(result.data)
            }
        })
    }

    const getTeacherByName = () =>{

        if(teacherName == ""){
            axios.post(url+"/teacher/all").then(Response =>{
                const result = Response.data
                if(result.status == "success"){
                    setTeachers(result.data)
                }
            })
        }else{
            const body ={
                "teacherName":teacherName
            }
            axios.post(url+"/teacher/name",body).then(Response =>{
                const result = Response.data
                if(result.status == "success"){
                    setTeachers(result.data)
                }else{
                    window.alert(result.messege)
                }
            })
        }
    }

    return(
        <div className="container">
            <br/>
            <b>Search Teacher By Name : </b>
            <input type="text" onChange={e=>{setTeacherName(e.target.value)}} />
            <button className="button-edit" onClick={getTeacherByName}>Search</button>
            <br/>
            Hint : Enter either firstname or lastname of the person
            <table className="table table-responsive">
                <thead className="tableHead">
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Contact</th>
                        <th>Designation</th>
                        <th>New Designation</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    {
                        teachers.map((teacher) =>{
                            return <TeacherDesignationRow t={teacher} />
                        })
                        
                    }
                </tbody>

            </table>
        </div>
    )
}

export default AssignRole