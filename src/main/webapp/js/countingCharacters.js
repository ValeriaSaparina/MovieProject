function counting() {
    const textArea = document.getElementById("bio");
    let val = textArea.value
    if (val.length > 127) {
        val = val.slice(0, 127)
        textArea.value = val
    }
    document.getElementById('counter').innerText = `${val.length}/127`;
}