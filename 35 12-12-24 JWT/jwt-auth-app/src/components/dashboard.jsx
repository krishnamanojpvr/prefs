import React from "react";
import { useNavigate } from "react-router-dom";

const Dashboard = ({ user, isAuthenticated }) => {
  const navigate = useNavigate();

  if (!isAuthenticated) {
    navigate("/login");
    return null;
  }

  return (
    <div className="container">
      <h2>Welcome to {user}!</h2>
      <p>You have successfully logged in.</p>
    </div>
  );
};

export default Dashboard;
