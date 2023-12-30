import React from "react"
import { useParams } from "react-router-dom"
export default function ProductDetails() {
  const params = useParams()
  return (
    <div>
      <h1>ProductDetails</h1>
      <h3>{params.id}</h3>
    </div>
  )
}
