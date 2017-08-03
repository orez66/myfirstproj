function addresdet(){
		$.ajax({
			cache:false,
			url: "reservationdetailControllerAj?action=add",
			data:{
				userName:'uuu'
			},
			success: function (result)
			{
				 $('html, body').animate({
				        scrollTop: $("#RESERVATIONDETAILS").offset().top
				    }, 3000); 
				$("#formresdetupdate").html($(result).find("#formresdet"));
			},
			dataType: 'html'
			}
		);
	}

function addresdet2()
{
	event.preventDefault();
	var $form = $('#formresdet'),
	resdetid = $form.find('input[name="id"]').val(),
	zimid= $form.find('input[name="idzimmer"]').val(),
	numg= $form.find('input[name="numguests"]').val(),
	bb= $form.find('input[name="baby"]').val(),
	note = $form.find('input[name="notes"]').val(),
	sdate = $form.find('input[name="startdate"]').val(),
	edate = $form.find('input[name="enddate"]').val(),
	a=$form.find('input[name = "action_type"]').val(),
	servlet=$form.attr('action');
	$.ajax
	({
		cache:false,
		type:'POST',
		url:servlet,
		data:{
			id:resdetid,
			idzimmer:zimid,
			numguests:numg,
			baby:bb,
			notes:note,
			startdate:sdate,
			enddate:edate,
			action_type:a
			
			 },
		datatype:'html',
		success:function(result)
		{
			
			$("#resdet_rows").html($(result).find("#tablereservationdetail")); 
			$('#formresdet').hide();
		}
	});
	}

function deleteresdet (x){
	
	$.ajax({
	
		cache:false,
		url: "reservationdetailControllerAj?action=delete&id="+x,
		data:{
			userName:'uuu'
		},
		success: function (result)
		{
			 $('html, body').animate({
			        scrollTop: $("#RESERVATIONDETAILS").offset().top
			    }, 3000); 
			$("#resdet_rows").html($(result).find("#tablereservationdetail"));
			
			
		},
		dataType: 'html'
		}
	);
}

function updateresdet (x){
	$.ajax({
		cache:false,
		url: "reservationdetailControllerAj?action=update&id="+x,
		data:{
			userName:'uuu'
		},
		success: function (result)
		{
			 $('html, body').animate({
			        scrollTop: $("#RESERVATIONDETAILS").offset().top
			    }, 3000); 
			$("#formresdetupdate").html($(result).find("#formresdet"));
			$('#attached_docs :option[value=""]').atrr('selected');
		},
		dataType: 'html'
		}
	);
}

function updateresdet2()
	{
	event.preventDefault();
	var $form = $('#formresdet'),
	resdetid = $form.find('input[name="id"]').val(),
	zimid= $form.find('input[name="idzimmer"]').val(),
	numg= $form.find('input[name="numguests"]').val(),
	bb= $form.find('input[name="baby"]').val(),
	note = $form.find('input[name="notes"]').val(),
	sdate = $form.find('input[name="startdate"]').val(),
	edate = $form.find('input[name="enddate"]').val(),
	a=$form.find('input[name = "action_type"]').val(),
	servlet=$form.attr('action');
	$.ajax
	({
		cache:false,
		type:'POST',
		url:servlet,
		data:{
			id:resdetid,
			idzimmer:zimid,
			numguests:numg,
			baby:bb,
			notes:note,
			startdate:sdate,
			enddate:edate,
			action_type:a
			
			 },
		datatype:'html',
		success:function(result)
		{
			
			$("#resdet_rows").html($(result).find("#tablereservationdetail")); 
			$('#formresdet').hide();
		}
	});
	}

function findGetParameter(parameterName) {
    var result = null,
        tmp = [];
    location.search
        .substr(1)
        .split("&")
        .forEach(function (item) {
          tmp = item.split("=");
          if (tmp[0] === parameterName) result = decodeURIComponent(tmp[1]);
        });
    return result;
}

function doadd(){
	var z = findGetParameter("action");
	if(z =="add"){
	document.getElementById("id").readOnly = false;
	document.getElementById("idlabel").innerHTML = "id reaquire";
	}
}
$(document).ready(function(){
	
	  // Add smooth scrolling to all links in navbar + footer link
	  $(".navbar a[href = '#RESERVATIONDETAILS'], footer a[href='#myPage']").on('click', function(event) {
		  alert("s");
		  $.ajax(
					{
						
						cache: false,
						url:"reservationdetailControllerAj?action=reservationdetaillist",
						data:{xxx:"xxx"},
						success: function(result)
						{
							$("#resdet_rows").html($(result).find("#tablereservationdetail"));
						},
						dataType: 'html'
						
					}		
			);
	    // Make sure this.hash has a value before overriding default behavior
	    if (this.hash !== "") {
	      // Prevent default anchor click behavior
	      event.preventDefault();

	      // Store hash
	      var hash = this.hash;

	      // Using jQuery's animate() method to add smooth page scroll
	      // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
	      $('html, body').animate({
	        scrollTop: $(hash).offset().top
	      }, 900, function(){
	   
	        // Add hash (#) to URL when done scrolling (default click behavior)
	        window.location.hash = hash;
	      });
	    } // End if
	  });
	  
	  $(window).scroll(function() {
	    $(".slideanim").each(function(){
	      var pos = $(this).offset().top;

	      var winTop = $(window).scrollTop();
	        if (pos < winTop + 600) {
	          $(this).addClass("slide");
	        }
	    });
	  });
})