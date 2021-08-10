function renderPager(id, currentPage, totalPage, gap) {
    var container = document.getElementById(id);

    //begin of paging, display first page
    if (currentPage >= gap + 2)
    {
        container.innerHTML += "<a href='managequiz?page=1'>1</a>";
        if (currentPage > gap + 2)
        {
            container.innerHTML += "...";
        }
    }

    //display amount pages before currentPage, amount = gap
    for (var i = currentPage - gap; i < currentPage; i++)
    {
        if (i >= 1) {
            container.innerHTML += "<a href='managequiz?page=" + i + "'>" + i + "</a>";
        }
    }

    //current Page
    container.innerHTML += "<span>" + currentPage + "</span>";

    //display amount pages after currentPage, amount = gap
    for (var i = currentPage + 1; i <= currentPage + gap; i++)
    {
        if (i <= totalPage) {
            container.innerHTML += "<a href='managequiz?page=" + i + "'>" + i + "</a>";
        }
    }

    //end of paging, display end-page
    if (currentPage <= totalPage - gap - 1)
    {
        if (currentPage < totalPage - gap - 1) {
            container.innerHTML += "...";
        }
        container.innerHTML += "<a href='managequiz?page=" + totalPage + "'>" + totalPage + "</a>";
    }
}

function confirmDelete(id){
    if (confirm('Are you sure?')){
        document.location='delete?id='+id;
    }
}