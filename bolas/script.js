const canvas = document.querySelector("canvas")
const ctx = canvas.getContext("2d")


canvas.width=innerWidth
canvas.height=innerHeight

let bolas = []
for(let i= 0; i<50; i++){
    bolas.push(new Bola(Math.random()*canvas.width, Math.random()*canvas.height)
)
}
function animar(){

    ctx.clearRect(0,0,canvas.width,canvas.height)

    bolas.forEach(bola=> {
        bolas.forEach(bolaTarget=>{

            let dx = bolaTarget.x - bola.x
            let dy = bolaTarget.y - bola.y
            let dist = Math.sqrt(dx**2 + dy**2)

            if(dist<300){
            ctx.beginPath()
            ctx.moveTo(bola.x, bola.y)
            ctx.lineTo(bolaTarget.x, bolaTarget.y)
            ctx.stroke()
            ctx.closePath()   
            }

        })
        bola.dibujar()
        bola.mover()    
    })
    requestAnimationFrame(animar)
}
animar()