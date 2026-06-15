import { useEffect, useState } from "react";
import "./App.css";

function App() {
  const [pacientes, setPacientes] = useState([]);
  const [medicos, setMedicos] = useState([]);

  const [nombrePaciente, setNombrePaciente] = useState("");
  const [rutPaciente, setRutPaciente] = useState("");

  const [nombreMedico, setNombreMedico] = useState("");
  const [especialidad, setEspecialidad] = useState("");

  const cargarDatos = () => {
    fetch("http://localhost:8080/bff/pacientes")
      .then((res) => res.json())
      .then((data) => setPacientes(data))
      .catch((error) => console.error("Error pacientes:", error));

    fetch("http://localhost:8080/bff/medicos")
      .then((res) => res.json())
      .then((data) => setMedicos(data))
      .catch((error) => console.error("Error medicos:", error));
  };

  useEffect(() => {
    cargarDatos();
  }, []);

  const agregarPaciente = () => {
    fetch("http://localhost:8080/bff/pacientes", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        id: Date.now(),
        nombre: nombrePaciente,
        rut: rutPaciente,
      }),
    }).then(() => {
      setNombrePaciente("");
      setRutPaciente("");
      cargarDatos();
    });
  };

  const eliminarPaciente = (id) => {
    fetch(`http://localhost:8080/bff/pacientes/${id}`, {
      method: "DELETE",
    }).then(() => cargarDatos());
  };

  const agregarMedico = () => {
    fetch("http://localhost:8080/bff/medicos", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        id: Date.now(),
        nombre: nombreMedico,
        especialidad: especialidad,
      }),
    }).then(() => {
      setNombreMedico("");
      setEspecialidad("");
      cargarDatos();
    });
  };

  const eliminarMedico = (id) => {
    fetch(`http://localhost:8080/bff/medicos/${id}`, {
      method: "DELETE",
    }).then(() => cargarDatos());
  };

  return (
    <div className="App">
      <h1>MediFlow</h1>

      <h2>Pacientes</h2>

      <input
        type="text"
        placeholder="Nombre paciente"
        value={nombrePaciente}
        onChange={(e) => setNombrePaciente(e.target.value)}
      />

      <input
        type="text"
        placeholder="RUT paciente"
        value={rutPaciente}
        onChange={(e) => setRutPaciente(e.target.value)}
      />

      <button onClick={agregarPaciente}>Agregar paciente</button>

      <ul>
        {pacientes.map((paciente) => (
          <li key={paciente.id}>
            {paciente.nombre} - {paciente.rut}
            <button onClick={() => eliminarPaciente(paciente.id)}>
              Eliminar
            </button>
          </li>
        ))}
      </ul>

      <h2>Médicos</h2>

      <input
        type="text"
        placeholder="Nombre médico"
        value={nombreMedico}
        onChange={(e) => setNombreMedico(e.target.value)}
      />

      <input
        type="text"
        placeholder="Especialidad"
        value={especialidad}
        onChange={(e) => setEspecialidad(e.target.value)}
      />

      <button onClick={agregarMedico}>Agregar médico</button>

      <ul>
        {medicos.map((medico) => (
          <li key={medico.id}>
            {medico.nombre} - {medico.especialidad}
            <button onClick={() => eliminarMedico(medico.id)}>
              Eliminar
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;